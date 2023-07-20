package me.gurwi.s3ssocraft.objects;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@RequiredArgsConstructor
public class SexOffender {

    private final UUID victimUUID;
    private final int requiredInculations;

    @Setter
    private int currentInculations;

    public void incrementInculations() {
        currentInculations++;
    }

}
