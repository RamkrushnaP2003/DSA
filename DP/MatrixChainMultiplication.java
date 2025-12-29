import java.util.Arrays;

public class MatrixChainMultiplication {
    public static int mcm(int[] nums, int i, int j) {
        if(i==j) return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++) { // k -> 0-1
            int cal = nums[i-1] * nums[k] * nums[j] + mcm(nums, i, k) + mcm(nums, k+1, j);
            min = Math.min(cal, min);
        }
        return min;
    }

    public static int mcm(int[] nums, int i, int j, int dp[][]) {
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i; k<j; k++) { // k -> 0-1
            int cal = nums[i-1] * nums[k] * nums[j] + mcm(nums, i, k) + mcm(nums, k+1, j);
            min = Math.min(cal, min);
        }
        return dp[i][j]=min;
    }

    public static int mcm(int nums[]) {
        int n=nums.length;
        int dp[][] = new int[n][n];
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
        }
        for(int i=n-1; i>=1; i--) {
            for(int j=i+1; j<n; j++) {
                int min=Integer.MAX_VALUE;
                for(int k=i; k<j; k++) { // k -> 0-1
                    int cal = nums[i-1] * nums[k] * nums[j] + dp[i][k] + dp[k+1][j];
                    min = Math.min(cal, min);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3};
        System.out.println(mcm(nums, 1, nums.length-1));
        int[][] dp = new int[nums.length][nums.length];
        for(int i[]: dp) {
            Arrays.fill(i, -1);
        }
        System.out.println(mcm(nums, 1, nums.length-1, dp));
        System.out.println(mcm(nums));
    }
}


// security.basic.enabled=false


// #spring.datasource.url=jdbc:mysql://bshinstance.cntuzpgt85ar.ap-southeast-1.rds.amazonaws.com:3306/bsh_cew?autoReconnect=true

// # spring.datasource.url=jdbc:mysql://bshinstance-encrypted.cntuzpgt85ar.ap-southeast-1.rds.amazonaws.com:3306/bsh_cew?autoReconnect=true
// # spring.datasource.username=cewuser
// # spring.datasource.password=hWH&U2hiy43@bIu
// spring.datasource.url=jdbc:mysql://localhost:3306/bsh_cew
// spring.datasource.username=root
// spring.datasource.password=ram12345

// spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
// spring.datasource.testOnBorrow=true
// spring.datasource.validationQuery=SELECT 1

// server.port=8282

// spring.jpa.show-sql=false

// spring.jpa.generate-ddl=true
// #Make sure by mistake you dont add space for value of ddl-auto 
// #spring.jpa.hibernate.ddl-auto=update
// #spring.jpa.properties.hibernate.hbm2ddl.auto=update
// spring.jpa.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
// spring.jpa.hibernate.naming-strategy=org.hibernate.cfg.ImprovedNamingStrategy
// spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
// spring.jpa.properties.hibernate.current_session_context_class=org.springframework.orm.hibernate4.SpringSessionContext

// spring.http.multipart.max-file-size=30MB
// spring.http.multipart.max-request-size=30MB

// server.session.cookie.max-age=72000
// server.session.timeout=72000
// homeUrl=http://13.250.230.128:8282/

// insurance-person1-IN=Marine.Tan@bshg.com
// insurance-person2-IN=RAEES.SHAIKH-ext@bshg.com
// insurance-person3-IN=Rajesh1.Apogee@tataaig.com

// insurance-person4-SG=clement.mak@bshg.com
// insurance-person5-SG=martin.li@bshg.com
// insurance-person6-SG=Emily-SL.Goh@aig.com

// insurance-person7-MY=Jinfoong.kok@bshg.com
// insurance-person8-MY=jenette.limj@bshg.com
// insurance-person9-MY=YeowThuan.Ang@bshg.com
// insurance-person10-MY=kelvin.fong@bshg.com
// insurance-person11-MY=Sharmila.Thangarajoo@aig.com
// insurance-person12-MY=Zahbanun.Heait@aig.com


// insurance-person13-TH=anchalee.chainarin@bshg.com
// insurance-person14-TH=phatcharaphon.chukaeo@bshg.com
// insurance-person15-TH=jitlada.makied@bshg.com
// insurance-person16-TH=pawinee.potisut@bshg.com
// insurance-person17-TH=nutrudee.kusolsinchai@aig.com
// insurance-person18-TH=Marine.Tan@bshg.com
// # cewuploads=/src/main/resources/uploads/
// cewuploads=uploads/

// extendedDate=90

// #bucketName=ontrackcrm

// admin-email=tndl.grv001@gmail.com




// <?xml version="1.0" encoding="UTF-8"?>
// <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
//          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
//     <modelVersion>4.0.0</modelVersion>

//     <groupId>bshcew</groupId>
//     <artifactId>bshcew</artifactId>
//     <version>0.0.1-SNAPSHOT</version>
//     <packaging>jar</packaging>

//     <name>bshcew</name>
//     <description>bshcew project for LDU</description>

//     <parent>
//         <groupId>org.springframework.boot</groupId>
//         <artifactId>spring-boot-starter-parent</artifactId>
//         <version>1.5.3.RELEASE</version>
//         <relativePath/> <!-- lookup parent from repository -->
//     </parent>

//     <properties>
//         <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
//         <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
//         <java.version>1.8</java.version>
//     </properties>

//     <dependencies>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-data-jpa</artifactId>
//         </dependency>
        
//         <dependency>
// 		    <groupId>mysql</groupId>
// 		    <artifactId>mysql-connector-java</artifactId>
// 		    <version>8.0.28</version>
// 		</dependency> 
//         <dependency>
//     <groupId>org.springframework</groupId>
//     <artifactId>spring-jdbc</artifactId>
//     <version>4.3.8.RELEASE</version>
// </dependency>
//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-thymeleaf</artifactId>
//         </dependency>

//         <!-- https://mvnrepository.com/artifact/javax.mail/mail -->
//         <dependency>
//             <groupId>javax.mail</groupId>
//             <artifactId>mail</artifactId>
//             <version>1.4</version>
//         </dependency>

//         <dependency>
//             <groupId>org.json</groupId>
//             <artifactId>json</artifactId>
//             <version>20210307</version>
//         </dependency>
//         <dependency>
//             <groupId>org.apache.maven.plugins</groupId>
//             <artifactId>maven-resources-plugin</artifactId>
//             <version>3.2.0</version>
//         </dependency>
        
//         <dependency>
//             <groupId>org.apache.poi</groupId>
//             <artifactId>poi-ooxml</artifactId>
//             <version>3.17</version>
//         </dependency>

//         <dependency>
//             <groupId>org.springframework.boot</groupId>
//             <artifactId>spring-boot-starter-freemarker</artifactId>
//         </dependency>
		
//         <!-- <dependency>
//             <groupId>com.itextpdf</groupId>
//             <artifactId>itextpdf</artifactId>
//             <version>5.5.13.2</version>
//             <type>jar</type>
//         </dependency> -->

//         <dependency>
//             <groupId>com.itextpdf</groupId>
//             <artifactId>itextpdf</artifactId>
//             <version>5.5.9</version> 
//         </dependency>

//         <dependency>
//             <groupId>com.razorpay</groupId>
//             <artifactId>razorpay-java</artifactId>
//             <version>1.4.8</version>
//         </dependency>

//         <dependency>
//             <groupId>org.freemarker</groupId>
//             <artifactId>freemarker</artifactId>
//             <version>2.3.31</version> <!-- or newer -->
//         </dependency>
//         <dependency>
//             <groupId>org.xhtmlrenderer</groupId>
//             <artifactId>flying-saucer-pdf</artifactId>
//             <version>9.1.22</version> <!-- or newer -->
//         </dependency>
	 
//         <dependency>
//             <groupId>com.itextpdf.tool</groupId>
//             <artifactId>xmlworker</artifactId>
//             <version>5.5.9</version>
//             <type>jar</type>
//         </dependency>

//         <dependency>
//             <groupId>org.apache.poi</groupId>
//             <artifactId>poi-ooxml</artifactId>
//             <version>3.15</version>
//         </dependency>

//         <dependency>
//             <groupId>org.apache.poi</groupId>
//             <artifactId>poi</artifactId>
//             <version>3.15</version>
//         </dependency>

//         <dependency>
//             <groupId>org.apache.commons</groupId>
//             <artifactId>commons-collections4</artifactId>
//             <version>4.1</version>
//         </dependency>
        
//         <dependency>
// 		    <groupId>net.sf.dozer</groupId>
// 		    <artifactId>dozer</artifactId>
// 		    <version>5.4.0</version>
// 		</dependency>
		
// 		<dependency>
// 		    <groupId>org.springframework.boot</groupId>
// 		    <artifactId>spring-boot-configuration-processor</artifactId>
// 		    <version>2.2.6.RELEASE</version>
// 		</dependency>
		
// 		<dependency>
// 		    <groupId>org.springframework.security</groupId>
// 		    <artifactId>spring-security-web</artifactId>
// 		    <version>${spring-security.version}</version>
// 		</dependency>
		
// 		  <dependency>
// 		    <groupId>org.springframework.security</groupId>
// 		    <artifactId>spring-security-config</artifactId>
// 		    <version>${spring-security.version}</version>
// 		  </dependency>
		  
// 		 	 <dependency>
// 			    <groupId>com.amazonaws</groupId>
// 			    <artifactId>aws-java-sdk-ses</artifactId>
// 			    <version>1.11.934</version>
// 			</dependency>
		
// 		<dependency>
// 	            <groupId>com.amazonaws</groupId>
// 	            <artifactId>aws-java-sdk-s3</artifactId>
// 	            <version>1.11.480</version>
// 	        </dependency>
		
// 		<dependency>
// 		    <groupId>javax.ws.rs</groupId>
// 		    <artifactId>javax.ws.rs-api</artifactId>
// 		    <version>2.0.1</version>
// 		</dependency>
		
// 		<dependency>
// 		    <groupId>com.sun.jersey</groupId>
// 		    <artifactId>jersey-server</artifactId>
// 		    <version>1.8</version>
// 		</dependency>

//         <dependency>
//             <groupId>com.opencsv</groupId>
//             <artifactId>opencsv</artifactId>
//             <version>3.8</version>
//         </dependency>

//         <dependency>
//             <groupId>com.jcraft</groupId>
//             <artifactId>jsch</artifactId>
//             <version>0.1.55</version> <!-- Or the latest version available -->
//         </dependency>

//     </dependencies>

//     <build>
//         <plugins>
//             <plugin>
//                 <groupId>org.springframework.boot</groupId>
//                 <artifactId>spring-boot-maven-plugin</artifactId>
//             </plugin>
//         </plugins>
//     </build>


// </project>
