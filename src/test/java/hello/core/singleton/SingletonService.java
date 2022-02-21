package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    //객체를 생성하지 않고 호출 가능
    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }


}
