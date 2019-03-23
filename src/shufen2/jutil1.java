package shufen2;

public class jutil1 {
	
	public void fang1() {
		double[] x0=new double[12];
		double[] x1=new double[12];
		double[] x2=new double[12];
		double[] x3=new double[12];
		double[] a=new double[4];
		double[] b=new double[4];
		double[] f=new double[12];
		double[][] m=new double[4][4];
		double[] s=new double[12];
		x0[0]=1;
		x0[1]=1;
		x0[2]=1;
		x0[3]=1;
		x0[4]=1;
		x0[5]=1;
		x0[6]=1;
		x0[7]=1;
		x0[8]=1;
		x0[9]=1;
		x0[10]=1;
		x0[11]=1;
		x1[0]=0;
		x1[1]=5;
		x1[2]=10;
		x1[3]=15;
		x1[4]=20;
		x1[5]=25;
		x1[6]=30;
		x1[7]=35;
		x1[8]=40;
		x1[9]=45;
		x1[10]=50;
		x1[11]=55;
		f[0]=0;
		f[1]=1.27;
		f[2]=2.16;
		f[3]=2.86;
		f[4]=3.44;
		f[5]=3.87;
		f[6]=4.15;
		f[7]=4.37;
		f[8]=4.51;
		f[9]=4.58;
		f[10]=4.02;
		f[11]=4.64;
		for(int i=0;i<12;i++) {
			x2[i]=x1[i]*x1[i];
		}
		for(int i=0;i<12;i++) {
			x3[i]=x1[i]*x1[i]*x1[i];
		}
		
		m[0][0]=0;
		for(int i=0;i<12;i++) {
			m[0][0]=m[0][0]+x0[i];
			      
		}
		m[0][1]=0;
		for(int i=0;i<12;i++) {
			m[0][1]=m[0][1]+x0[i]*x1[i];
			      
		}
		m[0][2]=0;
		for(int i=0;i<12;i++) {
			m[0][2]=m[0][2]+x0[i]*x2[i];
			      
		}
		m[0][3]=0;
		for(int i=0;i<12;i++) {
			m[0][3]=m[0][3]+x0[i]*x3[i];
			      
		}
		m[1][0]=0;
		for(int i=0;i<12;i++) {
			m[1][0]=m[1][0]+x1[i];
			      
		}
		m[1][1]=0;
		for(int i=0;i<12;i++) {
			m[1][1]=m[1][1]+x2[i];
			      
		}
		m[1][2]=0;
		for(int i=0;i<12;i++) {
			m[1][2]=m[1][2]+x1[i]*x2[i];
			      
		}
		m[1][3]=0;
		for(int i=0;i<12;i++) {
			m[1][3]=m[1][3]+x1[i]*x3[i];
			      
		}
		m[2][0]=0;
		for(int i=0;i<12;i++) {
			m[2][0]=m[2][0]+x2[i];
			      
		}
		m[2][1]=0;
		for(int i=0;i<12;i++) {
			m[2][1]=m[2][1]+x3[i];
			      
		}
		m[2][2]=0;
		for(int i=0;i<12;i++) {
			m[2][2]=m[2][2]+x2[i]*x2[i];
			      
		}
		m[2][3]=0;
		for(int i=0;i<12;i++) {
			m[2][3]=m[2][3]+x2[i]*x3[i];
			      
		}
		m[3][0]=0;
		for(int i=0;i<12;i++) {
			m[3][0]=m[3][0]+x3[i];
			      
		}
		m[3][1]=0;
		for(int i=0;i<12;i++) {
			m[3][1]=m[3][1]+x3[i]*x1[i];
			      
		}
		m[3][2]=0;
		for(int i=0;i<12;i++) {
			m[3][2]=m[3][2]+x3[i]*x2[i];
			      
		}
		m[3][3]=0;
		for(int i=0;i<12;i++) {
			m[3][3]=m[3][3]+x3[i]*x3[i];
			      
		}
		b[0]=0;
		for(int i=0;i<12;i++) {
			b[0]=b[0]+f[i]*x0[i];
			      
		}
		b[1]=0;
		for(int i=0;i<12;i++) {
			b[1]=b[1]+f[i]*x1[i];
		}
		b[2]=0;
		for(int i=0;i<12;i++) {
			b[2]=b[2]+f[i]*x2[i];
		}
		b[3]=0;
		for(int i=0;i<12;i++) {
			b[3]=b[3]+f[i]*x3[i];
		}
		int n=4;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		for(int i=0;i<n;i++) {
			double max=zhuan(m[i][i]);
			int gh=-1;
			for(int j=i;j<n;j++)
			{
				if(zhuan(m[j][i])>max) {
					max=zhuan(m[j][i]);
					gh=j;
				}	
			}
			if(max==0) {
				System.out.println("no unique solution");
				return;
			}
			if(gh!=-1&&max!=0){
				double ab=0;
				double sd=0;
				for(int j=0;j<n;j++) {
					ab=m[i][j];
					m[i][j]=m[gh][j];
					m[gh][j]=ab;		 
				}
				    sd=b[i];
				    b[i]=b[gh];
				    b[gh]=sd;	
			}
			for(int h2=i+1;h2<n;++h2) {
				double num=m[h2][i];
				if(num!=0) {
			  for(int hi=i;hi<n;hi++) {
				m[h2][hi]=m[h2][hi]-((num/(double)m[i][i]))*m[i][hi];
			  }
			  b[h2]= b[h2]-((num/(double)m[i][i]))*b[i];
			  }
			}	
		}
		 a[n-1]=b[n-1]/m[n-1][n-1];
		 System.out.println(b[3]);
	    for(int i=n-1;i>=0;i--) {
	    	 double sum=0;
	    	for(int j=i+1;j<n;j++) {
	    		sum=sum+m[i][j]*a[j];
	    	}
	    	a[i]=(b[i]-sum)/m[i][i];
	      }
		 System.out.println("表达式为");
		 String  snm="y=";
		  snm=snm+a[2]+"*t"+"+"+a[1]+"*t^2"+"+"+a[0]+"*t^3";
		  System.out.println(snm);
		
	}
	public void fang2() {
		double[] x0=new double[12];
		double[] x1=new double[12];
		double[] x2=new double[12];
		double[] a=new double[3];
		double[] b=new double[3];
		double[] f=new double[12];
		double[][] m=new double[3][3];
		double[] s=new double[12];
		x0[0]=1;
		x0[1]=1;
		x0[2]=1;
		x0[3]=1;
		x0[4]=1;
		x0[5]=1;
		x0[6]=1;
		x0[7]=1;
		x0[8]=1;
		x0[9]=1;
		x0[10]=1;
		x0[11]=1;
		x1[0]=0;
		x1[1]=5;
		x1[2]=10;
		x1[3]=15;
		x1[4]=20;
		x1[5]=25;
		x1[6]=30;
		x1[7]=35;
		x1[8]=40;
		x1[9]=45;
		x1[10]=50;
		x1[11]=55;
		f[0]=0;
		f[1]=1.27;
		f[2]=2.16;
		f[3]=2.86;
		f[4]=3.44;
		f[5]=3.87;
		f[6]=4.15;
		f[7]=4.37;
		f[8]=4.51;
		f[9]=4.58;
		f[10]=4.02;
		f[11]=4.64;
		for(int i=0;i<12;i++) {
			x2[i]=x1[i]*x1[i];
		}
		m[0][0]=0;
		for(int i=0;i<12;i++) {
			m[0][0]=m[0][0]+x0[i];      
		}
		m[0][1]=0;
		for(int i=0;i<12;i++) {
			m[0][1]=m[0][1]+x0[i]*x1[i];      
		}
		m[0][2]=0;
		for(int i=0;i<12;i++) {
			m[0][2]=m[0][2]+x0[i]*x2[i];      
		}
		m[1][0]=0;
		for(int i=0;i<12;i++) {
			m[1][0]=m[1][0]+x1[i];	      
		}
		m[1][1]=0;
		for(int i=0;i<12;i++) {
			m[1][1]=m[1][1]+x2[i];      
		}
		m[1][2]=0;
		for(int i=0;i<12;i++) {
			m[1][2]=m[1][2]+x1[i]*x2[i];      
		}
		m[2][0]=0;
		for(int i=0;i<12;i++) {
			m[2][0]=m[2][0]+x2[i];      
		}
		m[2][1]=0;
		for(int i=0;i<12;i++) {
			m[2][1]=m[2][1]+x2[i]*x1[i];      
		}
		m[2][2]=0;
		for(int i=0;i<12;i++) {
			m[2][2]=m[2][2]+x2[i]*x2[i];	      
		}
		b[0]=0;
		for(int i=0;i<12;i++) {
			b[0]=b[0]+f[i]*x0[i];
			      
		}
		b[1]=0;
		for(int i=0;i<12;i++) {
			b[1]=b[1]+f[i]*x1[i];
		}
		b[2]=0;
		for(int i=0;i<12;i++) {
			b[2]=b[2]+f[i]*x2[i];
		}
		int n=3;
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
			System.out.print(m[i][j]+" ");
			}
			System.out.println("");
		}
		for(int i=0;i<n;i++) {
			double max=zhuan(m[i][i]);
			int gh=-1;
			for(int j=i;j<n;j++)
			{
				if(zhuan(m[j][i])>max) {
					max=zhuan(m[j][i]);
					gh=j;
				}	
			}
			if(max==0) {
				System.out.println("no unique solution");
				return;
			}
			if(gh!=-1&&max!=0){
				double ab=0;
				double sd=0;
				for(int j=0;j<n;j++) {
					ab=m[i][j];
					m[i][j]=m[gh][j];
					m[gh][j]=ab;		 
				}
				    sd=b[i];
				    b[i]=b[gh];
				    b[gh]=sd;	
			}
			for(int h2=i+1;h2<n;++h2) {
				double num=m[h2][i];
				if(num!=0) {
			  for(int hi=i;hi<n;hi++) {
				m[h2][hi]=m[h2][hi]-((num/(double)m[i][i]))*m[i][hi];
			  }
			  b[h2]= b[h2]-((num/(double)m[i][i]))*b[i];
			  }
			}	
		}
		 a[n-1]=b[n-1]/m[n-1][n-1];
	    for(int i=n-1;i>=0;i--) {
	    	 double sum=0;
	    	for(int j=i+1;j<n;j++) {
	    		sum=sum+m[i][j]*a[j];
	    	}
	    	a[i]=(b[i]-sum)/m[i][i];
	      }
		 System.out.println("表达式为");
		 String  snm="y=";
		  snm=snm+a[2]+"+"+a[1]+"*t"+"+"+a[0]+"*t^2";
		  System.out.println(snm);
	
	}
	public double zhuan(double s) {
		if(s>=0)
			return s;
		else
			return 0-s;
					
		
	}
}
