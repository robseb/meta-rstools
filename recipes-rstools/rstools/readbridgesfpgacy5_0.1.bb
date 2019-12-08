# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read any bridge to FPGA address" 
SECTION = "rstools" 
LICENSE = "GPL-2"
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=bff2b7959c4b3958a8ae19f6a39a59ac"
SRC_URI = "gitsm://github.com/robseb/rstools.git;protocol=https"
SRCREV = "259251b7b0be412026747285a0cf41fd4018c326" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-readBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-readBridge ${D}${bindir}
}
