import calculatorUseSwitch
 
import unittest

class TestStringMethods(unittest.TestCase):
    def test_sum_positive(self):
        self.assertEqual( calculatorUseSwitch.add(0, 5), 5)    
    def test_sum_negative(self):
        self.assertEqual(calculatorUseSwitch.add(10000000000,1), 10000000001)

    def test_sub_positive(self):
        self.assertEqual(calculatorUseSwitch.sub(10, 5), 5)    
    def test_sub_negative(self):
        self.assertEqual(calculatorUseSwitch.sub(1, 10000000001,), -10000000000)

    def test_mul_positive(self):
        self.assertEqual(calculatorUseSwitch.mul(0, 5), 0)    
    def test_mul_negative(self):
        self.assertEqual(calculatorUseSwitch.mul(-5,-5), 25)

    def test_div_positive(self):
        self.assertEqual(calculatorUseSwitch.div(25, 5), 5)    
    def test_div_negative(self):
        self.assertEqual(calculatorUseSwitch.div(2,0), None)

if __name__ == '__main__':
    unittest.main()

