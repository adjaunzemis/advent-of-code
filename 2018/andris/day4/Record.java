import java.util.Date;
import java.util.Arrays;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Record implements Comparable
{

    private Date epoch;
    private String message;

    public Record(String recordStr)
    {
        String[] subparts = recordStr.split("[ ]+");

        try
        {
            epoch = new SimpleDateFormat("[yyyy-MM-dd hh:mm]").parse(subparts[0] + " " + subparts[1]);
        }
        catch (ParseException e)
        {
            System.out.println("Date parsing exception");
            e.printStackTrace();
        }

        message = String.join(" ", Arrays.copyOfRange(subparts, 2, subparts.length));
    }

    public Date getEpoch()
    {
        return epoch;
    }

    @Override
    public int compareTo(Object o)
    {
        if (!(o instanceof Record))
        {
            throw new ClassCastException();
        }
        Record r = (Record) o;
        return epoch.compareTo(r.getEpoch());
    }

    @Override
    public String toString()
    {
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatter.format(epoch) + ": " + message;
    }

}