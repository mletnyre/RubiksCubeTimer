import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Time{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Id;
    private String time;

    Time(String time){
        
    }
}