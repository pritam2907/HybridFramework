package testng.pratice;

public class MyChromeDriver {

	public MyChromeDriver() {
		System.out.println("Launching chrome browser!!");
	}
	
	public Window manage() {
		System.out.println("manage the driver");
		return new Window();
	}
}
class Window{
	
	public Window window() {
		System.out.println("manage window");
		return this;
	}
	
	public void maximize() {
		System.out.println("maximized Screen");
	}
	
	public void fullScreen() {
		System.out.println("browser set to full screen");
	}
	
	
	
	
}
