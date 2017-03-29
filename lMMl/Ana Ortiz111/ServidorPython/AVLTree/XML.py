import xml.etree.cElementTree as ET

class XML(object):
	def __init__(self):

	def crearXML(self, idNode):
		root = ET.Element("root")
		doc = ET.SubElement(root, "doc")

		ET.SubElement(doc, "ID", name="nodo").text = idNode
		#ET.SubElement(doc, "field2", name="nodo " + x).text = "some vlaue2"

		tree = ET.ElementTree(root)
		tree.write("filename.xml")