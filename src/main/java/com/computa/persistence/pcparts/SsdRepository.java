<<<<<<< HEAD:src/main/java/com/computa/persistence/pcparts/SsdRepository.java
package com.computa.persistence.pcparts;
=======
package com.app.persistence.pcparts;
>>>>>>> parent of 207be9b (Merge branch 'main' of https://github.com/ezencomputa/computa):src/main/java/com/app/persistence/pcparts/SsdRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Ssd;

public interface SsdRepository extends JpaRepository<Ssd, Long>{
    
}
