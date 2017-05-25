import unittest
import json_validation

class TestStringMethods(unittest.TestCase):
    def test_isjson(self):
        self.assertTrue(json_validation.is_valid_json('{"key":"dhje"}'))
        self.assertTrue(json_validation.is_valid_json('{"key":15}'))
        self.assertTrue(json_validation.is_valid_json('{"dsfd":15.2,"df":"df"}'))
        self.assertTrue(json_validation.is_valid_json('{"12":None}'))
        self.assertTrue(json_validation.is_valid_json('{"d" :False}'))
        self.assertTrue(json_validation.is_valid_json('{"sdsdf":True}'))
        self.assertFalse(json_validation.is_valid_json('{"1555ssw":aaa}'))
        self.assertFalse(json_validation.is_valid_json('{ke{}" y":15".2}'))
        self.assertFalse(json_validation.is_valid_json('{"":"skjd"sjd,";s"}'))
        self.assertFalse(json_validation.is_valid_json('{"k]":"sdsd"}'))
        self.assertTrue(json_validation.is_valid_json('{}'))
        self.assertFalse(json_validation.is_valid_json('{,}'))
        self.assertFalse(json_validation.is_valid_json('{:}'))
        self.assertFalse(json_validation.is_valid_json('{}}'))
        self.assertFalse(json_validation.is_valid_json('{k:j}'))
        self.assertFalse(json_validation.is_valid_json('dfd'))
        self.assertFalse(json_validation.is_valid_json('{}[]'))
        self.assertFalse(json_validation.is_valid_json('{122}'))


if __name__ == '__main__':
    unittest.main()
