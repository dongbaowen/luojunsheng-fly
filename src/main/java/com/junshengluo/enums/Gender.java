package com.junshengluo.enums;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 性别
 */
public enum Gender {

    FEMALE(0, "女"),
    MALE(1, "男");

    private Integer code;

    private String name;

    private static Map<Integer, Gender> CODE_MAP;

    static {
        CODE_MAP = Maps.newHashMap();
        for (Gender gender : Gender.values()) {
            CODE_MAP.put(gender.code, gender);
        }
    }

    Gender(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Gender fromCode(Integer code) {
        return CODE_MAP.get(code);
    }
}
