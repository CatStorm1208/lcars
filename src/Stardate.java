import java.time.*;

public class Stardate
{
    LocalDate now = LocalDate.now();
    LocalDate c = LocalDate.of(2318, 7, 5);

    public int stardate()
    {
        return Math.round(Duration.between(now.atStartOfDay(), c.atStartOfDay()).toDays() / -0.397766856f);
    }
}