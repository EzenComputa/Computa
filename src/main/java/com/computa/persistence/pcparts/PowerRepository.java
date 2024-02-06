<<<<<<< HEAD:src/main/java/com/computa/persistence/pcparts/PowerRepository.java
package com.computa.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.computa.entity.pcparts.Power;

public interface PowerRepository extends JpaRepository<Power, Long>{
=======
package com.app.persistence.pcparts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.pcparts.PcPower;

public interface PowerRepository extends JpaRepository<PcPower, Long>{
>>>>>>> parent of 207be9b (Merge branch 'main' of https://github.com/ezencomputa/computa):src/main/java/com/app/persistence/pcparts/PowerRepository.java
    
}
