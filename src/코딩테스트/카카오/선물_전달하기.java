package 코딩테스트.카카오;

import java.util.Collections;
import java.util.HashMap;

public class 선물_전달하기 {
    public static void main(String[] args) {

    }
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> giftScore = new HashMap<>();
        HashMap<String, HashMap<String, Integer>> giftRecords = new HashMap<>();

        for (String friend : friends) {
            giftScore.put(friend, 0);
            giftRecords.put(friend, new HashMap<>());
        }

        for (String gift : gifts) {
            String[] giftInfo = gift.split(" ");
            String giver = giftInfo[0];
            String receiver = giftInfo[1];
            giftScore.put(giver, giftScore.get(giver) + 1);
            giftScore.put(receiver, giftScore.get(receiver) - 1);
            giftRecords.get(giver).put(receiver, giftRecords.get(giver).getOrDefault(receiver, 0) + 1);
        }

        HashMap<String, Integer> giftsNextMonth = new HashMap<>();
        for (String friend : friends) {
            giftsNextMonth.put(friend, 0);
        }

        for (String giver : friends) {
            for (String receiver : friends) {
                if (giver.equals(receiver)) continue;
                int giverGifts = giftRecords.get(giver).getOrDefault(receiver, 0);
                int receiverGifts = giftRecords.get(receiver).getOrDefault(giver, 0);
                if (giverGifts > receiverGifts || (giverGifts == receiverGifts && giftScore.get(giver) > giftScore.get(receiver))) {
                    giftsNextMonth.put(receiver, giftsNextMonth.get(receiver) + 1);
                }
            }
        }

        return Collections.max(giftsNextMonth.values());
    }
}

class GiftDetail {
    private String from;
    private String to;

    public GiftDetail(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}

/*
* - 선물 받은 기록이 있다 -> 더 많은 선물을 준 사람이 다음 달에 선물을 받음
* - 두 사람간에 주고 받은 기록이 없거나 주고 받은 수가 같다. -> 선물지수가 더 큰사람이 작은 사람에게 받음
*       선물지수 ? 자신이 준 선물수 - 자신이 받은 선물 수
*           선물지수가 같다 ? 선물을 주고받지 않음
* - 리턴할 값 : 선물을 가장 많이 받은 친구의 선물 수
*
* [의사 코드]
* gift
*
*
* */