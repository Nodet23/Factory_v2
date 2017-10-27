import java.util.HashMap;

public class Factory {
    private static Factory instance=null;
    private HashMap<String,Comanda> cache;
    final static Logger logger=Logger.getLogger(Factory.class);
    private Factory() {
        cache=new HashMap<String, Comanda>();
    }

    public static Factory getInstance() {
        if (instance == null){
            instance=new Factory();
        }
        return instance;
    }
    public Comanda getComand(String clase){
        Comanda cmd;
        cmd=cache.get(clase);
        if (cmd == null) {
            try{Class c=Class.forName("dsa."+clase);
                cmd = (Comanda)c.newInstance();
                cache.put(clase,cmd);
                logger.info("Nueva consulta");
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        return cmd;
    }

}