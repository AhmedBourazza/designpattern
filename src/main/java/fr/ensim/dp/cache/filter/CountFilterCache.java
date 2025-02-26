package fr.ensim.dp.cache.filter;

public class CountFilterCache implements IFilterCache{
    IFilterCache next;
    int counter=0;
    @Override
    public byte[] doAdd(String key, byte[] buf) {
        counter++;
        if(next!=null){
            return next.doAdd(key, buf);
        }
        else
            return buf;
    }

    @Override
    public byte[] doRetreive(String key, byte[] buf) {
        return new byte[0];
    }

    @Override
    public IFilterCache setNext(IFilterCache next) {
        return this.next = next;
    }
}
