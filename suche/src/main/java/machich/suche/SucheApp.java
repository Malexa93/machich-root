package machich.suche;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;


@SpringBootApplication
public class SucheApp 
{

	
	public static void main(String[] args) {
		SpringApplication.run(SucheApp.class, args);
	}
	
	 @Bean(initMethod = "start", destroyMethod = "stop")
	    public Server inMemoryH2DatabaseServer() throws SQLException {
	        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9091");
	}
}
