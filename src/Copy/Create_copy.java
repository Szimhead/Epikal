package Copy;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Create_copy {
	

	

	//pozyskiwanie formatu pliku
	public static void getFormat(String path) {
		String format="";
		int i=path.length()-1;
		char tmp=path.charAt(i);
		while(tmp!='.') {
			format+=tmp;
			i--;
			tmp=path.charAt(i);
		}
		Parameters.format=new StringBuilder(format).reverse().toString();
	}
	
	//ustawianie œcie¿ki zapisu______________
	//domyœlna - w tym samym folderze, z którego pochodzi plik wejsciowy
	public static void defaultPath(File file) {
		String path=file.getAbsolutePath();
		int i=path.length();
		while(!path.substring(i-1, i).equals("\\")) {
			System.out.println(path.substring(i-1, i));
			i--;
		}
		
		Parameters.outPath=path.substring(0,i);
		System.out.println(Parameters.outPath);
	}
	
	//kopiowanie
	public static void copy() {
		for(int i=0;i<Parameters.amount;i++) {
		      final int percent = i+1;
			try {
				Parameters.fis=new FileInputStream(new File(Parameters.inPath));
				Parameters.fos=new FileOutputStream(new File(Parameters.outPath+Parameters.name+i+"."+Parameters.format));
				System.out.println(Parameters.outPath+Parameters.name+i+"."+Parameters.format);
				byte[] data=new byte[1024];
				int b=0;
				while((b=Parameters.fis.read(data))!=-1) {
					Parameters.fos.write(data);
				}
				System.out.println("Kopia nr "+(i+1)+" gotowa");
				 SwingUtilities.invokeLater(new Runnable() {
				  public void run() {
				    Main.bar.setValue(percent);     
				    Main.bar.setIndeterminate(false); 

				  }
				});
			}
		catch(IOException e) {
				e.printStackTrace();
			}
			
		try {
			Parameters.fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Parameters.fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parameters.done++;
		}
		
	        if(!Desktop.isDesktopSupported()){
	            System.out.println("Desktop is not supported");
	            return;
	        }
	        File file=new File(Parameters.outPath);
	        Desktop desktop = Desktop.getDesktop();
	        if(file.exists())
				try {
					desktop.open(file);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	
}
