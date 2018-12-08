import andris.day3.InvalidClaimException;

import InvalidClaimException;

public class Claim
{

    private int identifier;
    private int marginLeft;
    private int marginTop;
    private int width;
    private int height;

    public Claim(String claimStr) throws InvalidClaimException
    {
        String[] subparts = claimStr.split("[ #,@x:]+");
        
        if (subparts.length == 6)
        {
            identifier = Integer.parseInt(subparts[1]);
            marginLeft = Integer.parseInt(subparts[2]);
            marginTop = Integer.parseInt(subparts[3]);
            width = Integer.parseInt(subparts[4]);
            height = Integer.parseInt(subparts[5]);
        }
        else
        {
            throw new InvalidClaimException("Must have six subparts: " + claimStr);
        }
    }

    public int getIdentifier()
    {
        return identifier;
    }
    
    public int getMarginLeft()
    {
        return marginLeft;
    }

    public int getWidth()
    {
        return width;
    }

    public int getMarginTop()
    {
        return marginTop;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean isCovered(int x, int y) {
        return ((x >= marginLeft) && (x < (marginLeft + width)) && (y >= marginTop) && (y < (marginTop + height)));
    }

}
