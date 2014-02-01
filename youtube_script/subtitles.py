import os

def processSubsection(lines, lineNumber):
	section = int(lines[lineNumber -1].strip())
	index = lineNumber + 1
	subtitle = ""
	while True:
		if (lines[index].strip() == ''):
			break;
		subtitle = subtitle + " %s "  % (lines[index].strip())
		index += 1
	if ('--' in subtitle):
		subtitle = subtitle.replace("--", "")

	print section, subtitle
	return
		
		
		
def processSubtitle(subtitleVideo):
	fp = open(subtitleVideo, "rt")
	lines = fp.readlines()
	fp.close()

	for i in xrange(len(lines)):
		if '-->' in lines[i]:
			processSubsection(lines, i)


def run():
	path = ""
	for filename in os.listdir(os.getcwd()):
		if "en.srt" in filename:
			processSubtitle(filename)

run()
