package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MajorityElement169Test {

    @Test
    public void testMajorityElement() {
        MajorityElement169 obj = new MajorityElement169();

        int[] arr1 = {3, 2, 3};
        assertThat(obj.majorityElement(arr1)).isEqualTo(3);

        int[] arr2 = {2,2,1,1,1,2,2};
        assertThat(obj.majorityElement(arr2)).isEqualTo(2);
    }
}