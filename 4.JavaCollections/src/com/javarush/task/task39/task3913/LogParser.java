package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {
	private Path logDir;

	public LogParser(Path logDir) {
		this.logDir = logDir;
	}

	@Override
	public int getNumberOfUniqueIPs(Date after, Date before) {
		return getUniqueIPs(after, before).size();
	}

	@Override
	public Set<String> getUniqueIPs(Date after, Date before) {
		return getIpSet(null, after, before);
	}

	@Override
	public Set<String> getIPsForUser(String user, Date after, Date before) {
		return getIpSet(user, after, before);
	}

	@Override
	public Set<String> getIPsForEvent(Event event, Date after, Date before) {
		return getIpSet(event, after, before);
	}

	@Override
	public Set<String> getIPsForStatus(Status status, Date after, Date before) {
		return getIpSet(status, after, before);
	}

	private Set<String> getIpSet(Object recordField, Date after, Date before) {
		Set<String> ipSet = new HashSet<>();
		for (LogRecord record : getParsedRecords(logDir)) {
			if (isDateInside(after, before, record.getDate()) && isFieldMatch(recordField, record)) {
				ipSet.add(record.getIp());
			}
		}
		return ipSet;
	}

	private boolean isDateInside(Date after, Date before, Date currentDate) {
		if (after != null) {
			if (currentDate.getTime() <= after.getTime())
				return false;
		}
		if (before != null) {
			if (currentDate.getTime() >= before.getTime())
				return false;
		}
		return true;
	}

	private boolean isFieldMatch(Object recordField, LogRecord record) {
		boolean criteria = false;
		if (recordField == null)
			return true;
		if (recordField instanceof String)
			criteria = record.getUser().equals(recordField);
		else if (recordField instanceof Event)
			criteria = record.getEvent().equals(recordField);
		else if (recordField instanceof Status)
			criteria = record.getStatus().equals(recordField);
		return criteria;
	}

	private List<LogRecord> getParsedRecords(Path logDir) {
		List<LogRecord> recordList = new ArrayList<>();
		try {
			for (File file : logDir.toFile().listFiles()) {
				if (file.isFile() && file.getName().endsWith(".log")) {
					for (String record : Files.readAllLines(file.toPath())) {
						recordList.add(new LogRecord(record));
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return recordList;
	}

	private class LogRecord {
		private String ip;
		private String user;
		private Date date;
		private Event event;
		private String taskNumber;
		private Status status;

		public LogRecord(String ip, String user, Date date, Event event, Status status) {
			this.ip = ip;
			this.user = user;
			this.date = date;
			this.event = event;
			this.status = status;
		}

		public LogRecord(String record) {
			String[] strings = record.split("\t");
			this.ip = strings[0].trim();
			this.user = strings[1];
			SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
			try {
				date = dateFormat.parse(strings[2]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String eventAndParameter[] = strings[3].split(" ");
			event = Event.valueOf(eventAndParameter[0]);
			if (eventAndParameter.length > 1)
				taskNumber = eventAndParameter[1];
			status = Status.valueOf(strings[4]);
		}

		public String getIp() {
			return ip;
		}

		public String getUser() {
			return user;
		}

		public Date getDate() {
			return date;
		}

		public Event getEvent() {
			return event;
		}

		public String getTaskNumber() {
			return taskNumber;
		}

		public Status getStatus() {
			return status;
		}
	}

}
