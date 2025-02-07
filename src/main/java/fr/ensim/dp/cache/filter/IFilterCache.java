package fr.ensim.dp.cache.filter;

/**
 * Chain of responsbility
 *
 */
public interface IFilterCache {

  byte[] doAdd(String key, byte[] buf);

  byte[] doRetreive(String key, byte[] buf);

  IFilterCache setNext(IFilterCache next);

}
