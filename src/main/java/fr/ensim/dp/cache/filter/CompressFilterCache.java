package fr.ensim.dp.cache.filter;

import org.apache.log4j.Logger;

public class CompressFilterCache implements IFilterCache{
    IFilterCache next;
    Logger logger = Logger.getLogger("LogFilterCache");
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        byte[] bufCompressed = compresser(buf);
        if (next == null) {
            return next.doAdd(key, bufCompressed);
        }
        else
            return bufCompressed;
    }

    private byte[] compresser(byte[] buf) {
        return null;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        byte[] bufDecompressed = decompresse(buf);
        if (next == null) {
            return next.doRetreive(key, bufDecompressed);
        }
        else 
            return bufDecompressed;
    }

    private byte[] decompresse(byte[] buf) {
        return null;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        this.next = next;
        return next;
    }
}
