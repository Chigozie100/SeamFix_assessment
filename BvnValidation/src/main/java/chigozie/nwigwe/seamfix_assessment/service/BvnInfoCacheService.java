package chigozie.nwigwe.seamfix_assessment.service;

import chigozie.nwigwe.seamfix_assessment.dto.BvnInfo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BvnInfoCacheService {
    public static final List<BvnInfo> BVN_INFO_LIST = List.of(
            composeBvnDetails("11131151819"),
            composeBvnDetails("22223782229"),
            composeBvnDetails("33408963333"),
            composeBvnDetails("46784444444"),
            composeBvnDetails("55555555555"),
            composeBvnDetails("66666666666"),
            composeBvnDetails("39777490777"),
            composeBvnDetails("88888888888"),
            composeBvnDetails("23095999999")
    );

    public static BvnInfo composeBvnDetails(String bvn) {
        return BvnInfo.builder()
                .bvn(bvn)
                .imageDetail(getDefaultBase64Image())
                .basicDetail(getDefaultBase64Image())
                .build();
    }

    public static String getDefaultBase64Image() {
        return "YWJjZGVmZw==";
    }


    public Optional<BvnInfo> findByBvn(String bvn) {
        return BVN_INFO_LIST.stream()
                .filter(bvnDetail -> bvnDetail.getBvn().equals(bvn))
                .findFirst();
    }
}
