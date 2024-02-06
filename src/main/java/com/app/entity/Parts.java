package com.app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Parts {
    CPU,
    GPU,
    Motherboard,
    PcCase,
    Psu,
    Ram,
    Cooler,
    PcStorage
}
