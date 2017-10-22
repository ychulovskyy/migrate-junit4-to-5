package git.ychulovskyy.examples.junit;

import org.springframework.stereotype.Service;

@Service
public class CalculationService {
    public int add(int left, int right) {
        return left + right;
    }
}
