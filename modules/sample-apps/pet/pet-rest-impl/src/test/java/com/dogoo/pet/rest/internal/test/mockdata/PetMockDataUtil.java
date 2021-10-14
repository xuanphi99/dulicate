package com.dogoo.pet.rest.internal.test.mockdata;


import com.dogoo.poc.pet.rest.dto.v1_0.Pet;

public class PetMockDataUtil {
    public static Pet buildPet(String name, String tag, Pet.Status  status) {
        Pet pet = buildPet(name, tag);

        pet.setStatus(status);

        return pet;
    }

    public static Pet buildPet(String name, String tag) {
        Pet pet = new Pet();

        pet.setName(name);
        pet.setTag(tag);

        return pet;
    }

}
