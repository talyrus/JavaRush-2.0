package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Taly on 04.09.2018.
 */
public class CachingProxyRetriever implements Retriever {
	Storage storage;
	OriginalRetriever originalRetriever;
	LRUCache<Long, Object> lruCache;

	public CachingProxyRetriever(Storage storage) {
		this.storage = storage;
		originalRetriever = new OriginalRetriever(storage);
		lruCache = new LRUCache<>(16);
	}

	@Override
	public Object retrieve(long id) {
		Object object = lruCache.find(id);
		if (object == null) {
			object = originalRetriever.retrieve(id);
			lruCache.set(id, object);
		}
		return object;
	}
}
