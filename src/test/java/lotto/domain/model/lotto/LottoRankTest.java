package lotto.domain.model.lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {


    @Test
    @DisplayName("6개의 번호를 맞추면 1등이 반환되어야 한다.")
    void firstRankTest() {
        LottoRank first = LottoRank.FIRST;

        LottoRank matched = LottoRank.getMatchedLotto(6, false);

        Assertions.assertThat(matched).isEqualTo(first);
    }

    @Test
    @DisplayName("5개의 번호를 맞추고 보너스 번호를 맞추면 2등이 반환되어야 한다.")
    void secondRankTest() {
        LottoRank second = LottoRank.SECOND;

        LottoRank matched = LottoRank.getMatchedLotto(5, true);

        Assertions.assertThat(matched).isEqualTo(second);
    }

    @Test
    @DisplayName("5개의 번호를 맞추고 보너스 번호를 맞추지 못하면 3등이 반환되어야 한다.")
    void thirdRankTest() {
        LottoRank third = LottoRank.THIRD;

        LottoRank matched = LottoRank.getMatchedLotto(5, false);

        Assertions.assertThat(matched).isEqualTo(third);
    }

    @Test
    @DisplayName("4개의 번호를 맞추면 4등이 반환되어야 한다.")
    void fourthRankTest() {
        LottoRank fourth = LottoRank.FOURTH;

        LottoRank matched = LottoRank.getMatchedLotto(4, false);

        Assertions.assertThat(matched).isEqualTo(fourth);
    }

    @Test
    @DisplayName("3개의 번호를 맞추면 5등이 반환되어야 한다.")
    void fifthRankTest() {
        LottoRank fifth = LottoRank.FIFTH;

        LottoRank matched = LottoRank.getMatchedLotto(3, false);

        Assertions.assertThat(matched).isEqualTo(fifth);
    }

    @Test
    @DisplayName("3개 미만의 번호를 맞추면 NONE이 반환되어야 한다")
    void noneRankTest() {
        LottoRank none = LottoRank.NONE;

        LottoRank matched1 = LottoRank.getMatchedLotto(2, false);
        LottoRank matched2 = LottoRank.getMatchedLotto(1, false);
        LottoRank matched3 = LottoRank.getMatchedLotto(0, false);

        Assertions.assertThat(matched1).isEqualTo(none);
        Assertions.assertThat(matched2).isEqualTo(none);
        Assertions.assertThat(matched3).isEqualTo(none);
    }

}