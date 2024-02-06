package com.computa.entity.pcparts;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// socket, formFactor, ramSlots, maxRam

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "motherboard")
public class Motherboard extends Product {


    @Column(name = "kinds")
    private String kinds;

    @Column(name = "socket")
    private String socket;

    @Column(name = "chipset")
    private String chipset;

    @Column(name = "cpuCount")
    private String cpuCount;

    @Column(name = "form_factor")
    private String formFactor;

    @Column(name = "memKind")
    private String memKind;

    @Column(name = "memSpeed")
    private String memSpeed;

    @Column(name = "memSlots")
    private String memSlots;

    @Column(name = "memChan")
    private String memChan;

    @Column(name = "memMax")
    private Integer memMax;
    
    @Column(name = "VGA")
    private String VGA;

    @Column(name = "PCIe4")
    private Boolean PCIe4;

    @Column(name = "PCIe3")
    private Boolean PCIe3 ;

    @Column(name = "PCI")
    private Boolean PCI;

    @Column(name = "PCIex16")
    private Integer PCIex16;

    @Column(name = "PCIex1")
    private Integer PCIex1;

    @Column(name = "PCIslot")
    private Integer PCISlot;

    @Column(name = "M2")
    private Boolean M2;

    @Column(name = "SATA3")
    private Boolean SATA3;

    @Column(name = "M2Count")
    private Integer M2Count;

    @Column(name = "SATA3Count")
    private Integer Sata3Count;
    
    @Column(name = "USB3")
    private Integer USB3;

    @Column(name = "USB2")
    private Integer USB2;

    @Column(name = "PCIe")
    private Boolean PCIe;

    @Column(name = "NVMe")
    private Boolean NVMe;

    @Column(name = "SATA")
    private Boolean SATA;

    @Column(name = "M2Form2242")
    private Boolean M2Form2242;

    @Column(name = "M2Form2260")
    private Boolean M2Form2260;

    @Column(name = "M2Form2280")
    private Boolean M2Form2280;

    @Column(name = "D-SUB")
    private Boolean DSUB;

    @Column(name = "DVI")
    private Boolean DVI;

    @Column(name = "HDMI")
    private Boolean HDMI;

    @Column(name = "DP")
    private Boolean DP;

    @Column(name = "BackUSB3")
    private Boolean BackUSB3;

    @Column(name = "BackUSB2")
    private Boolean BackUSB2;

    @Column(name = "RJ45")
    private Boolean RJ45;

    @Column(name = "BackAudio")
    private Boolean backAudio;

    @Column(name = "LanChip")
    private String LanChip;

    @Column(name = "LanSpeed")
    private String LanSpeed;

    @Column(name = "RJ45Count")
    private Integer RJ45Count;

    @Column(name = "audiochipset")
    private String audiochip;

}
