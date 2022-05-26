package notjorgecompany.BuenosAires;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;

import lombok.Getter;

public  abstract class BaseController {
    @Getter private Map<String, Object> model = new HashMap<>();

    protected void addModel(String key, Object value) {
        getModel().put(key, value);
    }

    protected void addRequest(String key, Object value) {
        Object request = getModel().get("request");
        if (null == request) {
            request = new HashMap<String, Object>();
            getModel().put("request", request);
        }

        if (request instanceof Map) {
            ((Map) request).put(key, value);
        }
    }

    protected void cleanModel() {
        model.clear();
    }

    protected void prepareLoger(Level logLevel) {
        java.util.logging.Logger globalLog = java.util.logging.Logger.getLogger("cl.transbank");
        globalLog.setUseParentHandlers(false);
        globalLog.addHandler(new ConsoleHandler() {
            {/*setOutputStream(System.out);*/setLevel(Level.ALL);}
        });
        globalLog.setLevel(logLevel);
    }
}
