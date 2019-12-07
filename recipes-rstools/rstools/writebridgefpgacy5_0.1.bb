# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to write to any HPS-FPGA Bridge address" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0"
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=87b5d45e84844e8cc3120f018557015c"
SRC_URI = "gitsm://github.com/robseb/rstools.git;protocol=https"
SRCREV = "259251b7b0be412026747285a0cf41fd4018c326" 
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-writeBridge"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-writeBridge ${D}${bindir}
}
