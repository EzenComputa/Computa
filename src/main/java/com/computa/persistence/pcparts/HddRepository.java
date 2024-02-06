<<<<<<< HEAD:src/main/java/com/computa/persistence/pcparts/HddRepository.java
package com.computa.persistence.pcparts;
=======
package com.app.persistence.pcparts;
>>>>>>> parent of 207be9b (Merge branch 'main' of https://github.com/ezencomputa/computa):src/main/java/com/app/persistence/pcparts/HddRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Hdd;

public interface HddRepository extends JpaRepository<Hdd, Long>{
    
}
