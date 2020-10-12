# 정규 표현식(Regular Expressions)
# 메타 문자 : 원래 그 문자가 가진 뜻이 아닌 특별한 용도로 사용되는 문자를 말한다.
# . ^ $ * + ? { } [ ] \ | ( )

# 임의의 문자
# 문자 클래스 [ ] => [와 ] 사이에는 어떤 문자도 들어갈 수 있다.
# [abc] => a, b, c 중 한 개의 문자와 매치
# [a-zA-Z] => 알파벳 모두
# [0-9] => 숫자
# \d => 숫자와 매치, [0-9]
# \D => 숫자가 아닌 것과 매치, [^0-9]
# \s => whitespace 문자와 매치, [ \t\n\r\f\v] 맨 앞의 빈 칸은 공백문자(space)를 의미한다.
# \S => whitespace 문자가 아닌 것과 매치, [^ \t\n\r\f\v]
# \w => 문자 + 숫자(alphanumeric)와 매치, [a-zA-Z0-9_]
# \W => 문자 + 숫자(alphanumeric)가 아닌 문자와 매치, [^a-zA-Z0-9_]

# 모든 문자
# . => \n를 제외한 모든 문자와 매치됨
# a.b => a + 모든문자 + b => a와 b라는 문자 사이에 어떤 문자가 들어가도 모두 매치
# [] 내에 사용된 . 문자는 모든 문자라는 의미가 아닌 문자 . 그대로를 의미한다. 

# 반복
# * => * 바로 앞의 문자가 0번에서 무한대로 반복될 수 있다. {0, }
# + => * 바로 앞의 문자가 1번에서 무한대로 반복될 수 있다. {1, }
# {m, n} => 바로 앞의 문자가 반복 횟수가 m번 부터 n번 까지 반복될 수 있다.
# ? => 바로 앞의 문자가 있어도 되고 없어도 된다. {0, 1} 

import re

p = re.compile('[a-z]+')

# match()는 문자열의 처음부터 정규식과 매치되는지 조사한다.
m = p.match('python')
print(m) # <re.Match object; span=(0, 6), match='python'>
m = p.match("3 python")
print(m) # None

m = p.match('python')
if m:
    print('Match found :', m.group())
else:
    print('No Match')
print('=' * 80)
    
# ========================================================================

# search()는 문자열에서 정규식과 매치되는 문자열이 존재하는가 조사한다.

m = p.search("python")
print(m) # <re.Match object; span=(0, 6), match='python'>
m = p.search("3 python")
print(m) # <re.Match object; span=(2, 8), match='python'>
print('=' * 80)

# ========================================================================

# findall()는 문자열에서 정규식과 매치되는 단어를 리스트로 리턴한다.

result = p.findall("life is too short")
print(result) # ['life', 'is', 'too', 'short']

for item in result:
    print(item)
# life
# is
# too
# short
print('=' * 80)

# ========================================================================

# finditer()는 findall()와 동일하지만 단어를 iterator 객체로 리턴한다.

result = p.finditer("life is too short")
print(result) # <callable_iterator object at 0x02F22990>

# iterator 객체는 각각 match 객체로 구성된다.
for item in result:
    print(item)
# <re.Match object; span=(0, 4), match='life'>
# <re.Match object; span=(5, 7), match='is'>
# <re.Match object; span=(8, 11), match='too'>
# <re.Match object; span=(12, 17), match='short'>
print('=' * 80)

# ========================================================================

# match 객체의 메소드
# group => 매치된 문자열을 리턴한다.
# start() => 매치된 문자열의 시작 위치를 리턴한다.
# end() => 매치된 문자열의 끝 위치를 리턴한다.
# span() => 매치된 문자열의 (시작, 끝) 에 해당되는 튜플을 리턴한다.

# p = re.compile('[a-z]+')
# m = p.match("python")
# 위 의 2줄을 아래와 같이 1줄로 사용할 수 있다.
m = re.match('[a-z]+', "python")
print(m.group()) # python
print(m.start()) # 0
print(m.end()) # 6
print(m.span()) # (0, 6)
print('=' * 80)

# ========================================================================

# | => "or"의 의미와 동일하다.
# A|B 라는 정규식이 있다면 이것은 A 또는 B라는 의미가 된다.

p = re.compile('Crow|Servo')
m = p.match('CrowHello')
print(m) # <re.Match object; span=(0, 4), match='Crow'>
print('=' * 80)

# ========================================================================

# ^ => 문자열의 맨 처음과 일치함을 의미한다. \A

m = re.search('^Life', 'Life is too short')
print(m) # <re.Match object; span=(0, 4), match='Life'>
m = re.search('\ALife', 'Life is too short')
print(m) # <re.Match object; span=(0, 4), match='Life'>
m = re.search('^Life', 'My Life')
print(m) # None
m = re.search('\ALife', 'My Life')
print(m) # None
print('=' * 80)

# ========================================================================

# $ => $는 문자열의 끝과 매치함을 의미한다. \Z

m = re.search('short$', 'Life is too short')
print(m) # <re.Match object; span=(12, 17), match='short'>
m = re.search('short\Z', 'Life is too short')
print(m) # <re.Match object; span=(12, 17), match='short'>
m = re.search('short$', 'Life is too short, you need python')
print(m) # None
m = re.search('short\Z', 'Life is too short, you need python')
print(m) # None
print('=' * 80)

# ========================================================================

# \b => 단어 구분자(Word boundary)
# \b는 Back Space를 의미하므로 단어 구분자임을 알려주기 위해 r을 붙여야 한다.
# \B => \b 반대로 whitespace로 구분된 단어가 아닌 경우 매치된다.

p = re.compile(r'\bclass\b')
m = p.search('no class at all')
print(m) # <re.Match object; span=(3, 8), match='class'>

p = re.compile(r'\Bclass\B')
m = p.search('no class at all')
print(m) # None
m = p.search('the declassified algorithm')
print(m) # <re.Match object; span=(6, 11), match='class'>
m = p.search('one subclass is')
print(m) # None
print('=' * 80)

# ========================================================================

# 그룹핑(Grouping) => # (와 )를 사용해 그룹을 만든다.

p = re.compile('(ABC)+')
m = p.search('ABCABCABC OK?')
print(m) # <re.Match object; span=(0, 9), match='ABCABCABC'>
print(m.group()) # ABCABCABC
print('=' * 80)

p = re.compile(r"\w+\s+\d+[-]\d+[-]\d+")
m = p.search("park 010-1234-1234")
print(m) # <re.Match object; span=(0, 18), match='park 010-1234-1234'>
print('=' * 80)

# group(index) 에서 index의 의미
# 0 => 매치된 전체 문자열
# 1, 2, ..., n => 각 그룹에 해당되는 문자열
# 그룹이 중첩되면 바깥에서 안으로 들어가며 인덱스가 증가한다.

p = re.compile(r"(\w+)\s+((\d+)[-]\d+[-]\d+)")
m = p.search("park 010-1234-1234")
print(m.group(1)) # park
print(m.group(2)) # 010-1234-1234
print(m.group(3)) # 010
print('=' * 80)

# 그룹핑된 문자열 재참조
p = re.compile(r'(\b\w+)\s+\1')
m = p.search('Paris in the the spring').group()
print(m) # the the

# 그룹핑 문자열에 이름 붙이기
p = re.compile(r"(?P<name>\w+)\s+((\d+)[-]\d+[-]\d+)")
m = p.search("park 010-1234-1234")
print(m.group("name")) # park

p = re.compile(r'(?P<word>\b\w+)\s+(?P=word)')
m = p.search('Paris in the the spring').group()
print(m) # the the
print('=' * 80)

p = re.compile(".+:")
m = p.search("http://google.com")
print(m.group()) # http:

# 긍정형 전방 탐색(Lookahead Assertions) => (?=...)
# ... 에 해당되는 정규식과 매치되어야 하며 문자열이 소비되지 않는다.
# (?=:) => ':'이 검색에 포함되지만 결과에서 제외되므로 ':'이 제거되는 효과가 있다.

p = re.compile(".+(?=:)")
m = p.search("http://google.com")
print(m.group()) # http

# 부정형 전방 탐색 => (?!...)
# ...에 해당되는 정규식과 매치되지 않아야 하며 문자열이 소비되지 않는다.

# .*[.].*$ => 파일명 + '.' + 확장자
# .*[.][^b].*$ => 확장자가 b로 시작하지 않으면 매칭
# .*[.]([^b]..|.[^a].|..[^t])$ => 1번째 b, 2번째 a, 3번째 t가 아니면 매칭
# .*[.]([^b].?.?|.[^a]?.?|..?[^t]?)$ => 확장명이 2글자도 매칭

# .*[.](?!bat$).*$ => bat로 끝나지 않으면 매칭
# .*[.](?!bat$|exe$).*$ => bat 또는 exe로 끝나지 않으면 매칭
print('=' * 80)

# ========================================================================

# sub()는 지정된 정규식과 매치되는 부분을 다른 문자로 바꾼다.
p = re.compile('(blue|white|red)')
m = p.sub('colour', 'blue socks and red shoes')
print(m) # colour socks and colour shoes
# 3번째 인수로 count 옵션을 사용하면 바꾸기 횟수를 지정할 수 있다.
m = p.sub('colour', 'blue socks and red shoes', count = 1)
print(m) # colour socks and red shoes















