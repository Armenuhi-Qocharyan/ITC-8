import json 
import unittest

class TestJsonFormat(unittest.TestCase):

#key -@ 
#   1.petq e grvac lini ("")-i mej 
#   2.chi krknvelu
#   3.prabel chpetq e parunaki
#   4.datark chpetq e lini

#value -n
#   1.kara lini int kam float tiv
#   2.kara @nduni true false kam null arjeq 
#   3.kara lini string`("")-i mej grvac, mej@ cankacac artahaytutyun baci (,)-ic
#   1.chpetq e lini datark(''), kara lini datark string(" ")
#   2.chpetq e lini string artahaytutyun aranc ("")-i`  11e2a
 
    def test_checkKeyValid_positive(self):
        self.assertTrue(json.checkKeyValid(['"aaa"','"b1"']), [])   
    def test_checkKeyValid_negative(self):
        self.assertFalse(json.checkKeyValid(['"a"','"b"','a']), [])

    def test_checkValueValid_positive(self):
        self.assertEqual(json.checkValueValid(['true', 'false', 'null', '"a1"', 10, 10.10]), 1)
    def test_checkValueValid_negative(self):
        self.assertEqual(json.checkValueValid(['tru', 'false', 'nul', 'a1', 10, 10.10]), 0)

    def test_checkRepeatingKey_positive(self):
        self.assertEqual(json.checkRepeatingKey(['key1','key2']), 1)    
    def test_checkRepeatingKey_negative(self):
        self.assertEqual(json.checkRepeatingKey(['key1','key2','key1']), 0)

    def test_checkCountKeyEqualCountValue_positive(self):
        self.assertEqual(json.checkCountKeyEqualCountValue(['key1','key2','key3'], ['1','2','"a"']), 1)    
    def test_checkCountKeyEqualCountValue_negative(self):
        self.assertEqual(json.checkCountKeyEqualCountValue(['', 'key2'], ['value1', 'value2']), 0)
    def test_checkCountKeyEqualCountValue_negative(self):
        self.assertEqual(json.checkCountKeyEqualCountValue(['a a', 'a'], ['value1', '"ddw12gr"']), 0)
    
#ete mutqagrac key-@ gtni kstananq True, ete chgtni False

    #def test_findKey_positiv(self):        
        #self.assertTrue(json.findKey(self.keysValid, self.valueValid1), [])   
    #def test_findKey_negativ(self):        
        #self.assertFalse(json.findKey(self.keysValid, self.valueValid1), [])    

if __name__ == '__main__':
    unittest.main()
