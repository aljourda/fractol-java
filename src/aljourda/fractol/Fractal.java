package aljourda.fractol;

public abstract class Fractal {
	 double x = 0;	//Move x
	 double y = 0;	//Move y
	 double z = 1;	//Zoom
	 double w = 0;	//Fractal width
	 double h = 0;	//Fractal height
	 int n=512;		//Iteration number

	 public Fractal(int width, int height){
		 n = 512;
		 z = 1;
		 w = width;
		 h = height;
	 }
	 
	public abstract int getPixel(int x, int y);
	
    public static int HSBtoRGB(float hue, float saturation, float value)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        if(saturation == 0.0F)
        {
            i = j = k = (int)(value * 255F + 0.5F);
        } else
        {
            float f3 = (hue - (float)Math.floor(hue)) * 6F;
            float f4 = f3 - (float)Math.floor(f3);
            float f5 = value * (1.0F - saturation);
            float f6 = value * (1.0F - saturation * f4);
            float f7 = value * (1.0F - saturation * (1.0F - f4));
            switch((int)f3)
            {
            case 0: // '\0'
                i = (int)(value * 255F + 0.5F);
                j = (int)(f7 * 255F + 0.5F);
                k = (int)(f5 * 255F + 0.5F);
                break;

            case 1: // '\001'
                i = (int)(f6 * 255F + 0.5F);
                j = (int)(value * 255F + 0.5F);
                k = (int)(f5 * 255F + 0.5F);
                break;

            case 2: // '\002'
                i = (int)(f5 * 255F + 0.5F);
                j = (int)(value * 255F + 0.5F);
                k = (int)(f7 * 255F + 0.5F);
                break;

            case 3: // '\003'
                i = (int)(f5 * 255F + 0.5F);
                j = (int)(f6 * 255F + 0.5F);
                k = (int)(value * 255F + 0.5F);
                break;

            case 4: // '\004'
                i = (int)(f7 * 255F + 0.5F);
                j = (int)(f5 * 255F + 0.5F);
                k = (int)(value * 255F + 0.5F);
                break;

            case 5: // '\005'
                i = (int)(value * 255F + 0.5F);
                j = (int)(f5 * 255F + 0.5F);
                k = (int)(f6 * 255F + 0.5F);
                break;
            }
        }
        return -16777216 | i << 16 | j << 8 | k << 0;
    }

}
