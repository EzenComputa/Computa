<<<<<<< HEAD:src/main/java/com/computa/persistence/pcparts/CpuRepository.java
package com.computa.persistence.pcparts;
=======
package com.app.persistence.pcparts;
>>>>>>> parent of 207be9b (Merge branch 'main' of https://github.com/ezencomputa/computa):src/main/java/com/app/persistence/pcparts/CpuRepository.java

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Cpu;

public interface CpuRepository extends JpaRepository<Cpu, Long>{
    
}
