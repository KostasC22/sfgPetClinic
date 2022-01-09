package guru.springframework.sfgpetclinic;

import com.havistudio.sfgpetclinic.SfgPetClinicApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = SfgPetClinicApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SfgPetClinicApplicationTests {

    @Test
    public void contextLoads() {

    }
}
