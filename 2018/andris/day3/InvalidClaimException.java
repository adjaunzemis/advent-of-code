package andris.day3;

public class InvalidClaimException extends Exception
{
    public InvalidClaimException(String errMsg)
    {
        super(errMsg);
    }
}
