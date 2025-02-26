package fr.ensim.dp.cache.filter;

public class EncryptFilterCache implements IFilterCache
{
    IFilterCache next;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        byte[] bufEncrypted = encrypt(buf);
        if (bufEncrypted != null)
            return next.doAdd(key, bufEncrypted);
        else
            return bufEncrypted;
    }

    private byte[] encrypt(byte[] buf) {
        return null;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        byte[] bufdecrypted = decrypt(buf);
        if (bufdecrypted != null)
            return next.doRetreive(key, bufdecrypted);
        else
            return bufdecrypted;
    }

    private byte[] decrypt(byte[] buf) {
        return null;
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }
}
