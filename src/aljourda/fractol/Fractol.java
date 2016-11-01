package aljourda.fractol;

import minilibX.Mlx;

public class Fractol {

	public static void main(String[] args) {
		Fractal s = null;
		String fractol = null;
		int width = 800;
		int height = 600;
		if(args != null && args.length > 0){
			fractol = args[0];
			//Select fractal
			if(fractol.equals("julia")){
				s = new FJulia(width, height);
			}else if(fractol.equals("mandelbrot")){
				s = new FMandelbrot(width, height);
			}else if(fractol.equals("tricorn")){
				s = new FTricorn(width, height);
			}
			if(args.length > 2){
				width = Integer.decode(args[1]);
				height = Integer.decode(args[2]);
			}
		}
		if(s != null){
			final Fractal f = s;
			final Mlx window = new Mlx(width, height, "Fractol "+fractol);
			window.setHook(new Mlx.Hook(){
				@Override
				public void mouseWheel(int distance) {
					double d = distance;
					d /= 10.0;
					f.z -= d;
			        expose();
			        window.repaint();
				}
				@Override
				public void mouseMotion(int x, int y) {
//					System.out.println("Mouse "+x+" "+y);
					if(f instanceof FJulia){
						FJulia julia = (FJulia)f;
						julia.cRe = (double)x / (double)julia.w * 4 - 2;
						julia.cIm = (double)y / (double)julia.h * 4 - 2;
				        expose();
				        window.repaint();
					}
				}
				@Override
				public void mouse(int code) {
//					System.out.println("Mouse "+code);
				}
				@Override
				public void key(int keycode) {
//					System.out.println("Key pressed "+keycode);
					if(keycode == 27){
						System.exit(0);
					}
					if(keycode == 37)
						f.x -= 0.1;
					if(keycode == 38)
						f.y -= 0.1;
					if(keycode == 39)
						f.x += 0.1;
					if(keycode == 40)
						f.y += 0.1;
					if(keycode == 109)
						f.z -= 0.1;
					if(keycode == 107)
						f.z += 0.1;
			        expose();
			        window.repaint();
				}
	
				@Override
				public void expose() {
//					System.out.println("Expose");
					window.clear();
				    for(int y = 0; y < f.h; y++){
				    	for(int x = 0; x < f.w; x++){
				    		window.pixelPut(x, y, f.getPixel(x, y));
				        }
					}
				}
			});
		}else{
			System.out.println("Usage : fractol {julia,mandelbrot,tricorn] [windowWidth] [windowHeight]");
			System.out.println("Quit with escape");
		}
	}

}
