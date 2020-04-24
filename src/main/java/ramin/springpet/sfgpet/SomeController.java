package ramin.springpet.sfgpet;

public class SomeController {

    private final MyService myService;

    public SomeController(MyService myService) {
        this.myService = myService;
    }
}
