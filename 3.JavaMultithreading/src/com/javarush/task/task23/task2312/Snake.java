package com.javarush.task.task23.task2312;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Taly on 14.07.2017.
 */
public class Snake {
	private List<SnakeSection> sections;
	private boolean isAlive;
	private SnakeDirection direction;

	public List<SnakeSection> getSections() {
		return sections;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public SnakeDirection getDirection() {
		return direction;
	}

	public void setDirection(SnakeDirection direction) {
		this.direction = direction;
	}

	public Snake(int x, int y) {
		this.sections = new ArrayList<>();
		SnakeSection snakeHead = new SnakeSection(x, y);
		sections.add(snakeHead);
		this.isAlive = true;
	}

	public int getX() {
		return sections.get(0).getX();
	}

	public int getY() {
		return sections.get(0).getY();
	}

	public void move() {
		if (isAlive == true) {
			if (this.direction == SnakeDirection.UP) {
				move(0, -1);
			} else if (this.direction == SnakeDirection.RIGHT) {
				move(1, 0);
			} else if (this.direction == SnakeDirection.DOWN) {
				move(0, 1);
			} else if (this.direction == SnakeDirection.LEFT) {
				move(-1, 0);
			}
		}
	}

	public void move(int x, int y) {
		SnakeSection newHead = new SnakeSection(sections.get(0).getX() + x, sections.get(0).getY() + y);
		checkBorders(newHead);
		checkBody(newHead);
		if (isAlive) {
			sections.add(0, newHead);
			sections.remove(sections.size() - 1);
			if (Room.game.getMouse().getX() == newHead.getX() && Room.game.getMouse().getY() == newHead.getY()) {
				Room.game.eatMouse();
				sections.add(0, newHead);
			}
		}
	}

	public void checkBorders(SnakeSection head) {
		if (head.getX() >= Room.game.getWidth() || head.getY() >= Room.game.getHeight()) {
			isAlive = false;
		}
	}

	public void checkBody(SnakeSection head) {
		if (this.getSections().contains(head)) {
			isAlive = false;
		}
	}


}


