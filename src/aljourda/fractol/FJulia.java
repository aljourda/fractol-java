package aljourda.fractol;

public class FJulia extends Fractal{
	
	public FJulia(int width, int height) {
		super(width, height);
	}

	double cRe = -0.7;
	double cIm = 0.27015;
	
	public int getPixel(int x, int y){
		//calculate the initial real and imaginary part of z, based on the pixel location and zoom and position values
		double newRe = 1.5 * (x - w / 2) / (0.5 * z * w) + super.x;
		double newIm = (y - h / 2) / (0.5 * z * h) + super.y;
		double oldRe = newRe;
		double oldIm = newIm;
		//i will represent the number of iterations
		int i;
		//start the iteration process
		for(i = 0; i < n; i++){
			//remember value of previous iteration
			oldRe = newRe;
			oldIm = newIm;
			//the actual iteration, the real and imaginary part are calculated
			newRe = oldRe * oldRe - oldIm * oldIm + cRe;
			newIm = 2 * oldRe * oldIm + cIm;
			//if the point is outside the circle with radius 2: stop
			if((newRe * newRe + newIm * newIm) > 4) break;
		}
		//use color model conversion to get rainbow palette, make brightness black if maxIterations reached
		return HSBtoRGB((i%256)/255.0f, 1.0f, (i < n) ? 1f : 0);
	}
}
