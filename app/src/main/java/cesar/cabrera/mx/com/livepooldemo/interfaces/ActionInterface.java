package cesar.cabrera.mx.com.livepooldemo.interfaces;


import cesar.cabrera.mx.com.livepooldemo.model.Enums;
import cesar.cabrera.mx.com.livepooldemo.model.GenericalError;

public interface ActionInterface {

    void OnErrorAction(GenericalError error);
    void OnActionSelected(Enums.ACCIONES action, Object... params);

}
