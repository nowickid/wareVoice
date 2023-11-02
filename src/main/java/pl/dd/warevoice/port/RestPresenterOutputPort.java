package pl.dd.warevoice.port;

public interface RestPresenterOutputPort {

    <T> void presentOk(T content);

    void presentError(Throwable t);
}
