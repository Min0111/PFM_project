package com.pfm.project.dto.store.response;

import com.pfm.project.dto.place.response.PlaceResponse;
import com.pfm.project.dto.store.response.StoreBriefInfoResponse;

import java.util.Comparator;

public class StoreCardMeterComparator implements Comparator<StoreBriefInfoResponse> {

    @Override
    public int compare(StoreBriefInfoResponse res1, StoreBriefInfoResponse res2) {
        if (res1.getMeter()> res2.getMeter())
            return 1;
        else if (res1.getMeter() < res2.getMeter())
            return -1;
        return 0;
    }
}
