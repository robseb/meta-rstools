# Robin Sebastian (https://github.com/robseb) 2019
SUMMARY = "bitbake-layers recipe"
DESCRIPTION = "rstools application to read the general purpose input line from the FPGA" 
SECTION = "rstools" 
LICENSE = "OPEN" 
PR = "r0" 
LIC_FILES_CHKSUM = "file://CHECKSUMFILE;md5=87b5d45e84844e8cc3120f018557015c"
SRC_URI = "gitsm://github.com/robseb/rstoolsCY5.git;protocol=https"
SRCREV = "87b5d45e84844e8cc3120f018557015c"
# use  git rev-parse HEAD to update

inherit cmake

S = "${WORKDIR}/git/FPGA-gpiRead"
FILES_${PN} += "${bindir}"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 FPGA-gpiRead ${D}${bindir}
}
