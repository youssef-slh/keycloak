package com.dgsg.integration.vouchers.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public enum Status {
    IN_PROGRESS,
    REJECTED,
    NOT_USED,
    CANCELED;

    private List<Status> allowedStatus = new ArrayList<>();

    static {
        IN_PROGRESS.allowedStatus = List.of(NOT_USED);
        REJECTED.allowedStatus = List.of(IN_PROGRESS);
        NOT_USED.allowedStatus = List.of();
        CANCELED.allowedStatus = List.of(IN_PROGRESS);
    }

    public boolean canTransitionTo(Status newStatus) {
        return newStatus != null && newStatus.allowedStatus.contains(this);
    }
}
