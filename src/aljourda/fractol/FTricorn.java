package aljourda.fractol;

public class FTricorn extends Fractal {

	public FTricorn(int width, int height) {
		super(width, height);
	}

	@Override
	public int getPixel(int x, int y) {
		// calculate the initial real and imaginary part of z, based on the
		// pixel location and zoom and position values
		double pr = 1.5 * (x - w / 2) / (0.5 * z * w) + super.x;
		double pi = (y - h / 2) / (0.5 * z * h) + super.y;
		double newRe = 0;
		double newIm = 0;
		double oldRe;
		double oldIm;
		// "i" will represent the number of iterations
		int i;
		// start the iteration process
		for (i = 0; i < n; i++) {
			// remember value of previous iteration
			oldRe = newRe;
			oldIm = newIm;
			// the actual iteration, the real and imaginary part are calculated
			newRe = oldRe * oldRe - oldIm * oldIm + pr;
			newIm = -2 * oldRe * oldIm + pi;
			// if the point is outside the circle with radius 2: stop
			if ((newRe * newRe + newIm * newIm) > 4)
				break;
		}
		//use color model conversion to get rainbow palette, make brightness black if maxIterations reached
		return HSBtoRGB((i%256)/255.0f, 1.0f, (i < n) ? 1f : 0);
	}
}
