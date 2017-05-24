import unittest
import testJson

class testJson(unittest.TestCase):
    def test_isValid(self):
        self.assertTrue(testJson.isValid('{\"key\":\"value\"}', [], []))
        self.assertTrue(testJson.isValid('{\"key\":\"value\", "\k1\":\"\"}', [], [])) 
        self.assertTrue(testJson.isValid('{\"key\":{}}', [], []))
        self.assertTrue(testJson.isValid('{\"key\":[]}', [], []))
        self.assertTrue(testJson.isValid('{\"key\":[value]}', [], []))
        self.assertTrue(testJson.isValid('{\"key\":123}', [], []))
        self.assertFalse(testJson.isValid('{\"\":\"key\"}', [], []))
        self.assertFalse(testJson.isValid('{\"\":\"\"}', [], [])) 
        self.assertFalse(testJson.isValid('{\"key\":\"value\", \"key\":12}', [], []))
        self.assertFalse(testJson.isValid('{\"key\":\"value\",}', [], []))
        self.assertFalse(testJson.isValid('{\"key\":\"value\"', [], []))
        self.assertFalse(testJson.isValid('\"key\":\"value\"', [], []))
        self.assertFalse(testJson.isValid('{key:\"value\"}', [], []))

    def test_isUnique(self):
        self.assertTrue(testJson.isUnique([key, key1, key3]))
        self.assertFalse(testJson.isUnique([key, key1, key2, key3, key1, key]))

if __name__ == '__main__':
    unittest.main()
